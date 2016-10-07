/*
 * jquery.finger
 * https://github.com/ngryman/jquery.finger
 *
 * Copyright (c) 2013 ngryman
 * Licensed under the MIT license.
 */

(function(c,u){function l(a){a.preventDefault();c.event.remove(e,"click",l)}function h(a,b){return(f?b.originalEvent.touches[0]:b)["page"+a.toUpperCase()]}function k(a,d,A){var g=c.Event(d,b);c.event.trigger(g,{originalEvent:a},a.target);g.isDefaultPrevented()&&(~d.indexOf("tap")&&!f?c.event.add(e,"click",l):a.preventDefault());A&&(c.event.remove(e,v+".finger",w),c.event.remove(e,m+".finger",n))}function w(a){b.x=h("x",a);b.y=h("y",a);b.dx=b.x-d.x;b.dy=b.y-d.y;b.adx=Math.abs(b.dx);b.ady=Math.abs(b.dy);
if(p=b.adx>g.motionThreshold||b.ady>g.motionThreshold){clearTimeout(q);b.orientation||(b.adx>b.ady?(b.orientation="horizontal",b.direction=0<b.dx?1:-1):(b.orientation="vertical",b.direction=0<b.dy?1:-1));for(;a.target&&a.target!==d.target;)a.target=a.target.parentNode;a.target!==d.target?(a.target=d.target,n.call(this,c.Event(m+".finger",a))):k(a,"drag")}}function n(a){var c=a.timeStamp||+new Date,e=c-d.time;clearTimeout(q);if(p||r||a.target!==d.target)a.target=d.target,e<g.flickDuration&&k(a,"flick"),
b.end=!0,e="drag";else{var f=x===a.target&&c-y<g.doubleTapInterval,e=f?"doubletap":"tap";x=f?null:d.target;y=c}k(a,e,!0)}var t=/chrome/i.exec(u),B=/android/i.exec(u),f="ontouchstart"in window&&!(t&&!B),t=f?"touchstart":"mousedown",m=f?"touchend touchcancel":"mouseup mouseleave",v=f?"touchmove":"mousemove",e=c("html")[0],d={},b={},p,r,z,q,x,y,g=c.Finger={pressDuration:300,doubleTapInterval:300,flickDuration:150,motionThreshold:5};c.event.add(e,t+".finger",function(a){var f=a.timeStamp||+new Date;z!=
f&&(z=f,d.x=b.x=h("x",a),d.y=b.y=h("y",a),d.time=f,d.target=a.target,b.orientation=null,r=p=b.end=!1,q=setTimeout(function(){r=!0;k(a,"press")},c.Finger.pressDuration),c.event.add(e,v+".finger",w),c.event.add(e,m+".finger",n),g.preventDefault&&(a.preventDefault(),c.event.add(e,"click",l)))})})(jQuery,navigator.userAgent);
