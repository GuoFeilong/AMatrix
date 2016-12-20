# AMatrix
matrix demo初始化
**一个下拉选择框的代码实现**


----------
效果如下;
![这里写图片描述](http://img.blog.csdn.net/20161220151955223?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZ2l2ZW1lYWNvbmRvbQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![这里写图片描述](http://img.blog.csdn.net/20161220152008742?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZ2l2ZW1lYWNvbmRvbQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


----------
GIF君看这里:这个是未调整Camera深度的GIF
![这里写图片描述](http://img.blog.csdn.net/20161220152039583?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZ2l2ZW1lYWNvbmRvbQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

调整完毕的效果如下,不会在出现显示不全的bug

![这里写图片描述](http://img.blog.csdn.net/20161220154411745?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvZ2l2ZW1lYWNvbmRvbQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
----------

 ####实现过程:
 

 1. 添加一个自定义view具备绘制bitmap和渐变Matrix的功能,用来展示倾斜变化的效果
 2. 布局的投机取巧:预览图中看到的倾斜布局下面还有一层和他一般大的textview,textview用来填充内容,而自定义view用来做翻转效果,注意调整Camera的z轴深度,这样矩阵变化的时候才不会显示不全
 3. 布局中加入承载数据view的父布局,用来动态的增加view
 4. 动态的增加view,填充view的内容
 5. 提供一个获取一个view背景的方法,拿到他的bitmap,给矩阵view呈现和旋转
 


----------
自定义Cameraview的内容

```
  private void setMatrixBitmap(Canvas canvas) {
		  // ondraw中绘制的方法,拿到外面提供的背景bitmap刷新
        if (bitmap != null) {
            matrix.reset();
            camera.save();
            // 改变camera的深度,zdeep最大为view的高度一半,这里是个变量根据属性动画的值,进行改变
            camera.translate(0,0, zDeep);
            // camera围绕x轴翻转的角度,也是根据属性动画的变化进行改变
            camera.rotateX(currentMatrix);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-getWidth() / 2, -getHeight() / 2);
            matrix.postTranslate(getWidth() / 2, getHeight() / 2);
            canvas.drawBitmap(bitmap, matrix, mPaint);
        }
    }
```

```
    private void animMartrix() {
    // 默认状态是关闭状态,每次执行开关动作都给当前状态赋值
        openState = !openState;
        // 暴露给activity根据开关状态做响应的事情
        if (openListener != null) {
            openListener.openOrClose(openState);
        }
        ValueAnimator valueAnimator;
        if (openState) {
            valueAnimator = ValueAnimator.ofFloat(0, 1.F);
        } else {
            valueAnimator = ValueAnimator.ofFloat(1.F, 0);

        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float percent = Float.valueOf(animation.getAnimatedValue().toString());
                // 动态的改变z轴深度和翻转的x轴角度
                currentMatrix = (int) (percent * matrixDegree);
                zDeep = getHeight() /2 * percent;
                invalidate();
            }
        });
        valueAnimator.setDuration(ANIM_TIME);
        valueAnimator.start();
    }

```

**接下来就是activity中对数据view的处理,包括动态填充数据改变layoutparamls以及列表容器的动画**

```

    private TextView creatTextView(TextViewEntity entity) {
    //动态的增加一个数据view
        TextView tv = new TextView(this);
        tv.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        tv.setBackgroundColor(entity.getBgColor());
        tv.setText(entity.getTextDesc());
        Drawable drawable = ContextCompat.getDrawable(this, entity.getDrawableRes());
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(null, null, drawable, null);
        int dp2px = dp2px(this, 5);
        tv.setPadding(dp2px, dp2px, dp2px, dp2px);
        return tv;
    }

```

```
    private void hideOrShowContainer(boolean openState) {
        allItemContainer.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator;
        // 属性动画改变数据container的状态
        if (openState) {
            valueAnimator = ValueAnimator.ofFloat(0.F, 1.F);
        } else {
            valueAnimator = ValueAnimator.ofFloat(1.F, 0.F);
        }
        valueAnimator.setDuration(350);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float percent = Float.valueOf(animation.getAnimatedValue().toString());
                // 动态的计算当前容器的高度,根据单个数据view的高度 * 数据集合的数量,
                int currentHeight = (int) (bitmapMartrix.getHeight() * data.size() * percent);
               
                if (percent >= 1) {
                    currentHeight += data.size() * 5;
                }
                // 由于代码改变了layoutparem所以需要从新指定当前view的位置信息,指定他在哪个view下面,
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, currentHeight);
                params.addRule(RelativeLayout.BELOW, R.id.fl_select_contaier);
                allItemContainer.setLayoutParams(params);
            }
        });
        valueAnimator.start();
    }

```

这样就实现了GIF中的选择器的效果;

## 源码下载地址,期待star谢谢[https://github.com/GuoFeilong/AMatrix](https://github.com/GuoFeilong/AMatrix) ##
