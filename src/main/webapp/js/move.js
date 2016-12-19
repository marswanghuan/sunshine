/*
 * 璋冪敤锛�
 * 	
 * 	move(obj, {left:10,top:20,opacity:0.8}, duration, fx, callback)
 * 
 * 绗簩涓弬鏁伴噷鐢ㄩ敭鍊煎鐨勫舰寮忥紝鍊兼病鏈夊崟浣嶏紝opacity鐨勫€间负0-1
 * 
 */


function move(obj, attrs, duration, fx, callback) {

    clearInterval(obj.timer);

    var startTime = new Date().getTime();
    //var b = parseFloat(getComputedStyle(obj)[attr]);
    //var c = target - b;

    //鍥犱负瑕佽繍鍔ㄥ涓睘鎬э紝骞朵笖澶氫釜灞炴€х殑璧峰鍜岀粨鏉熺殑鍊煎苟涓嶄竴鏍凤紝鎵€鏈塨鐨勫拰c鐨勫€煎氨涓嶈兘鍏辩敤锛屾垜浠鏍规嵁灞炴€х殑灞炴€х殑涓嶅悓锛屽垎鍒幓瀛樻斁b鍜宑鐨勫€硷紝鍚屾椂瀛樼殑鍊间篃瑕佹柟渚夸笅闈㈠畾鏃跺惊鐜笉鍚屽睘鎬х殑杩囩▼涓紝寰堟柟渚跨殑灏辫兘鎵惧埌
    //鎵€浠ワ紝鎴戜滑鍙互瀹氫箟涓€涓璞★紝鐒跺悗鏍规嵁涓嶅悓鐨勫睘鎬у瓨鏀句笉鍚岀殑b鍜宑
    var j = {};
    //閬嶅巻attrs锛岀劧鍚庢牴鎹噷闈㈢殑鍊硷紝鐢熸垚涓嶅悓鐨刡鍜宑
    for (var attr in attrs) {
        j[attr] = {}
        j[attr].b = parseFloat(getComputedStyle(obj)[attr]);
        j[attr].c = attrs[attr] - j[attr].b;
    }

    //console.dir(j);
    //
    //return;


    var d = duration;

    obj.timer = setInterval(function() {

        var t = new Date().getTime() - startTime;

        if ( t >= d ) {
            t = d;
        }

        //鏍规嵁浼犲叆杩涙潵鐨勫睘鎬э紝閫氳繃閬嶅巻鐨勬柟寮忔妸鎵€鏈夎杩愬姩鐨勫睘鎬ч兘璁＄畻涓€娆�
        for (var attr in attrs) {
            var b = j[attr].b;
            var c = j[attr].c;
            var value = Tween[fx](t, b, c, d);

            if ( attr == 'opacity' ) {
                obj.style[attr] = value;
            } else {
                obj.style[attr] = value + 'px';
            }
        }

        if ( t == d ) {
            clearInterval(obj.timer);
            if (typeof callback == 'function') {
                callback.call(obj);
            }

        }

    }, 16);
}

/*
 * t : time 宸茶繃鏃堕棿
 * b : begin 璧峰鍊�
 * c : count 鎬荤殑杩愬姩鍊�
 * d : duration 鎸佺画鏃堕棿
 * */

//Tween.linear();

var Tween = {
    linear: function (t, b, c, d){  //鍖€閫�
        return c*t/d + b;
    },
    easeIn: function(t, b, c, d){  //鍔犻€熸洸绾�
        return c*(t/=d)*t + b;
    },
    easeOut: function(t, b, c, d){  //鍑忛€熸洸绾�
        return -c *(t/=d)*(t-2) + b;
    },
    easeBoth: function(t, b, c, d){  //鍔犻€熷噺閫熸洸绾�
        if ((t/=d/2) < 1) {
            return c/2*t*t + b;
        }
        return -c/2 * ((--t)*(t-2) - 1) + b;
    },
    easeInStrong: function(t, b, c, d){  //鍔犲姞閫熸洸绾�
        return c*(t/=d)*t*t*t + b;
    },
    easeOutStrong: function(t, b, c, d){  //鍑忓噺閫熸洸绾�
        return -c * ((t=t/d-1)*t*t*t - 1) + b;
    },
    easeBothStrong: function(t, b, c, d){  //鍔犲姞閫熷噺鍑忛€熸洸绾�
        if ((t/=d/2) < 1) {
            return c/2*t*t*t*t + b;
        }
        return -c/2 * ((t-=2)*t*t*t - 2) + b;
    },
    elasticIn: function(t, b, c, d, a, p){  //姝ｅ鸡琛板噺鏇茬嚎锛堝脊鍔ㄦ笎鍏ワ級
        if (t === 0) {
            return b;
        }
        if ( (t /= d) == 1 ) {
            return b+c;
        }
        if (!p) {
            p=d*0.3;
        }
        if (!a || a < Math.abs(c)) {
            a = c;
            var s = p/4;
        } else {
            var s = p/(2*Math.PI) * Math.asin (c/a);
        }
        return -(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
    },
    elasticOut: function(t, b, c, d, a, p){    //姝ｅ鸡澧炲己鏇茬嚎锛堝脊鍔ㄦ笎鍑猴級
        if (t === 0) {
            return b;
        }
        if ( (t /= d) == 1 ) {
            return b+c;
        }
        if (!p) {
            p=d*0.3;
        }
        if (!a || a < Math.abs(c)) {
            a = c;
            var s = p / 4;
        } else {
            var s = p/(2*Math.PI) * Math.asin (c/a);
        }
        return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
    },
    elasticBoth: function(t, b, c, d, a, p){
        if (t === 0) {
            return b;
        }
        if ( (t /= d/2) == 2 ) {
            return b+c;
        }
        if (!p) {
            p = d*(0.3*1.5);
        }
        if ( !a || a < Math.abs(c) ) {
            a = c;
            var s = p/4;
        }
        else {
            var s = p/(2*Math.PI) * Math.asin (c/a);
        }
        if (t < 1) {
            return - 0.5*(a*Math.pow(2,10*(t-=1)) *
                Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
        }
        return a*Math.pow(2,-10*(t-=1)) *
            Math.sin( (t*d-s)*(2*Math.PI)/p )*0.5 + c + b;
    },
    backIn: function(t, b, c, d, s){     //鍥為€€鍔犻€燂紙鍥為€€娓愬叆锛�
        if (typeof s == 'undefined') {
            s = 1.70158;
        }
        return c*(t/=d)*t*((s+1)*t - s) + b;
    },
    backOut: function(t, b, c, d, s){
        if (typeof s == 'undefined') {
            s = 3.70158;  //鍥炵缉鐨勮窛绂�
        }
        return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
    },
    backBoth: function(t, b, c, d, s){
        if (typeof s == 'undefined') {
            s = 1.70158;
        }
        if ((t /= d/2 ) < 1) {
            return c/2*(t*t*(((s*=(1.525))+1)*t - s)) + b;
        }
        return c/2*((t-=2)*t*(((s*=(1.525))+1)*t + s) + 2) + b;
    },
    bounceIn: function(t, b, c, d){    //寮圭悆鍑忔尟锛堝脊鐞冩笎鍑猴級
        return c - Tween['bounceOut'](d-t, 0, c, d) + b;
    },
    bounceOut: function(t, b, c, d){
        if ((t/=d) < (1/2.75)) {
            return c*(7.5625*t*t) + b;
        } else if (t < (2/2.75)) {
            return c*(7.5625*(t-=(1.5/2.75))*t + 0.75) + b;
        } else if (t < (2.5/2.75)) {
            return c*(7.5625*(t-=(2.25/2.75))*t + 0.9375) + b;
        }
        return c*(7.5625*(t-=(2.625/2.75))*t + 0.984375) + b;
    },
    bounceBoth: function(t, b, c, d){
        if (t < d/2) {
            return Tween['bounceIn'](t*2, 0, c, d) * 0.5 + b;
        }
        return Tween['bounceOut'](t*2-d, 0, c, d) * 0.5 + c*0.5 + b;
    }
}