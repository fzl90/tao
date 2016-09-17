/**
 * TODO:元素居中插件
 * © 2013 by WXYCooL http://www.wxycool.com/
 * v1.0 2013-01-12
 * $('#box').center();
 */
(function($){
	jQuery.fn.center = function(){
		return this.each(function(){
			var $this = $(this);
			$this.css({
				position : 'fixed',
				top : ( $(window).height() - $this.height() ) / 2,
				left : ( $(window).width() - $this.width() ) / 2
			});
			$('.mask').css('height',$('body').height());
		});
	}
})(jQuery);

/**
 * TODO:元素水平居中插件
 * © 2013 by WXYCooL http://www.wxycool.com/
 * v1.0 2013-01-12
 * $('#box').center();
 */
(function($){
	jQuery.fn.centerLR = function(){
		return this.each(function(){
			var $this = $(this);
			$this.css({
				left : ( $(window).width() - $this.width() ) / 2
			});
		});
	}
})(jQuery);