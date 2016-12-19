var text=document.querySelector("#banner .text");
var highTitle=document.querySelector("#third h2");

var xLine=document.querySelector(".xLine");
var yLine=document.querySelector(".yLine");
var dls=document.querySelectorAll("#third dl");

//绾挎潯
var lines=document.querySelectorAll(".line");

//鍏嶈垂璇曞惉
var mCenter=document.querySelector(".mCenter");
var fouthTitle=document.querySelector("#fourth h2");

var scrollH=document.documentElement.scrollTop||document.body.scrollTop;

var back=document.getElementById("back");

//閿氱偣
var anchorLis=document.querySelectorAll("nav li");
for(var i=0;i<anchorLis.length;i++){
	anchorLis[i].index=i;
	if(i==0){
		continue;
	}
	anchorLis[i].onclick=function(){
		console.log(this.index)
		var anchorN=document.getElementById("anchor"+this.index);
		window.scrollTo(0,anchorN.offsetTop);
	};
}

//banner鍔ㄧ敾锛屽彧鏈夊湪婊氬姩鏉＄殑楂樺害灏忎簬300鐨勬椂鍊欐墠鍑烘晥鏋�
	if(scrollH<300){
		text.style.transition='0.2s all ease-in';
		text.style.width='400px';
		text.style.opacity='1';
		
		text.num=0;
		text.addEventListener('transitionend',function(){
			text.num++;
			
			if(text.num<=1){
				var html=document.querySelector("html");
				html.style.animation='0.3s shake';
			}
		});
	}else{
		text.style.width='400px';
		text.style.opacity='1';
	}
	

//绾挎潯鍔熻兘
line(scrollH);
function line(h){
	for(var i=0;i<lines.length;i++){
		if(h>lines[i].offsetTop-300){
			lines[i].style.transform='scaleX(1)';
		}
	}
};

//鍥涘ぇ浜偣鍔熻兘
var strengthsNum=0;
strengths(scrollH);
function strengths(h){
	if(h>highTitle.offsetTop-150){
		strengthsNum++;
		if(strengthsNum>1) return;

		xLine.style.transform='scale(1)';
		yLine.style.transform='scale(1)';
		
		for(var i=0;i<dls.length;i++){
			dls[i].style.transform='scale(1)';
		}
	}
}

//鍦嗙偣鍔熻兘
var circleNum=0;
circle(scrollH);
function circle(h){
	if(h>fouthTitle.offsetTop-100){
		circleNum++;
		if(circleNum>1) return;
	
		mCenter.style.opacity=1;
		mCenter.style.animation='1s fold linear';
		mCenter.addEventListener('animationend',function(){
			this.style.animation='';
			circleMove();
		});
	}
}

//榛戞礊鍔熻兘
var fifthNum=0;
blackHole(scrollH);
function blackHole(h){
	var fifthTitle=document.querySelector("#fifth h2");
	if(h>fifthTitle.offsetTop-200){
		fifthNum++;
		if(fifthNum>1) return;
	
		var fCenter=document.querySelector(".fCenter");
		var fImg=document.querySelector(".fImg");
		var fDivs=document.querySelectorAll(".fCenter div");
		
		fImg.style.animation='3s black linear';
		setTimeout(function(){
			//鏂囧瓧鍚歌繘鍘绘晥鏋�
			for(var i=0;i<fDivs.length;i++){
				fDivs[i].l=fDivs[i].offsetLeft;
				fDivs[i].t=fDivs[i].offsetTop;
				
				fDivs[i].style.left=fImg.offsetWidth/2-fDivs[i].offsetWidth/2+'px';
				fDivs[i].style.top=fImg.offsetHeight/2-fDivs[i].offsetHeight/2+'px';
				fDivs[i].style.transform='scale(0)';
			}
		},2000);
		
		fImg.addEventListener('animationend',imgEnd);
		function imgEnd(){
			//榛戞礊鏀惧ぇ缁撴潫鍚庯紝鏂囧瓧琚惛杩涘幓鐨勫姛鑳�
			this.style.transform='scale(0)';
			setTimeout(function(){
				for(var i=0;i<fDivs.length;i++){
					fDivs[i].className='';
					fDivs[i].style.left=fDivs[i].l+'px';
					fDivs[i].style.top=fDivs[i].t+'px';
					fDivs[i].style.transform='scale(1)';
				}
				
				fImg.style.transform='scale(1.2)';
				fImg.style.transition='0.2s transform';
				
				//鍐呭琚悙鍑烘潵鍚庯紝璁╅粦娲炶浆璧锋潵
				fImg.addEventListener('transitionend',function(){
					fImg.removeEventListener('animationend',imgEnd);
					fImg.style.animation='10s blackRotate linear infinite';
				});
			},500);
		};
	}
}

//瑙嗛鍔熻兘
//鎵嬮鐞�
var photoImgs=document.querySelectorAll("#photo img");
for(var i=0;i<photoImgs.length;i++){
	
	photoImgs[i].onmouseover=function(){
		for(var i=0;i<photoImgs.length;i++){
			photoImgs[i].nextElementSibling.style.width=0;
		}
		this.nextElementSibling.style.width='224px';
	};
}


var videoBtns=document.querySelectorAll("#photo li");
var vides=['9ddd1051ff','b03d1a16c1','f2f3b49850'];

for(var i=0;i<videoBtns.length;i++){
	videoBtns[i].index=i;
	videoBtns[i].onclick=function(ev){
		var video=document.createElement("div");
		var shadow=document.createElement("div");
		video.id='video';
		shadow.id='shadow';
		
		shadow.style.height=document.body.offsetHeight+'px';
		
		video.innerHTML='<embed src="http://yuntv.letv.com/bcloud.swf?uu=11ijmp9uua&amp;vu='+vides[this.index]+'&amp;pu=8FF9C0D595&amp;auto_play=1&amp;gpcflag=1" quality="high" width="960" height="540" align="middle" allowscriptaccess="never" allowfullscreen="true" type="application/x-shockwave-flash"></embed>';
		
		document.body.appendChild(shadow);
		document.body.appendChild(video);
		ev.cancelBubble=true;
	};
}

/*document.onclick=function(){
	var shadow=document.getElementById("shadow");
	var video=document.getElementById("video");
	
	if(!shadow) return;
	document.body.removeChild(shadow);
	document.body.removeChild(video);
};*/

document.addEventListener('click',function(){
	var shadow=document.getElementById("shadow");
	var video=document.getElementById("video");
	
	if(!shadow) return;
	document.body.removeChild(shadow);
	document.body.removeChild(video);
});


window.onscroll=function(){
	var scrollH=document.documentElement.scrollTop||document.body.scrollTop;
	line(scrollH);			//杩愬姩绾挎潯
	strengths(scrollH);		//鍥涘ぇ浜偣杩愬姩
	circle(scrollH);		//鍦嗙偣寮规€ц繍鍔�
	blackHole(scrollH);		//榛戞礊杩愬姩
	
	//鍥炲埌椤堕儴
	if(scrollH>500){
		back.style.display='block';
	}else{
		back.style.display='none';
	}
};


//杩愬姩鍦嗙偣
function circleMove(){
	//鑾峰彇鍦嗙偣
	var circles=document.querySelectorAll(".mCenter div:not(.arc)");
	var boxs=document.querySelectorAll("#fourth .box");
	
	//box鎺掑簭
	var sortBoxs=[];		//瀛樻斁浜嗘帓搴忕殑box
	for(var i=0;i<boxs.length;i++){
		sortBoxs.push(boxs[i]);
	}
	sortBoxs.sort(function(n1,n2){
		var num1=parseInt(n1.querySelector('.order').innerHTML);
		var num2=parseInt(n2.querySelector('.order').innerHTML);
		return num1-num2;
	});

	var last=circles[0];
	for(var i=0;i<circles.length;i++){
		(function(i){
			setTimeout(function(){
				last.className='';
				circles[i].className='active';
				last=circles[i];
				
				//鍦嗙偣瀵瑰簲鐨勫唴瀹瑰尯鍩熸樉绀哄嚭鏉�
				sortBoxs[parseInt(i/5)].style.opacity=1;
				
				//鎵€鏈夊渾鐐归兘璧板畬浜�
				if(i==circles.length-1){
					setTimeout(function(){
						last.className='';
						freeFn(sortBoxs);
					},100);
				}
			},i*100);
		})(i);
	}
}


//鍏嶈垂璇曞惉
function freeFn(sortBoxs){
	var fourthTitle=document.querySelector("#fourth h2");
	var freeBtn=document.querySelectorAll(".rightBtn div");
	var orders=document.querySelectorAll(".order");
	
	//99鍏冩寜閽繍鍔�
	freeBtn[0].style.animation='1.2s lightSpeedIn ease-in';
	freeBtn[0].addEventListener('animationend',function(){
		this.style.animation='';
		this.style.opacity=1;
		
		//涓嶇煡閬撲负浠€涔堣鏀惧湪瀹氭椂鍣ㄩ噷transition鎵嶆湁鏁堟灉
		setTimeout(function(){
			freeBtn[0].style.transition='1s transform';
			freeBtn[0].style.transform='skewY(-45deg)';
			freeBtn[0].style.transformOrigin='center';
			freeBtn[0].children[0].style.transform='skewY(45deg)';
		},100);
	});
	
	//鍛煎惛鐏�
	freeBtn[0].addEventListener('transitionend',function(){
		this.style.animation='1s breath linear infinite alternate';
		orders[0].style.animation='1s breathWhite linear infinite alternate';
		orders[4].style.animation='1s breathWhite linear infinite alternate';
		
		//绗簩涓寜閽樉绀�
		freeBtn[1].style.opacity=0.5;
		freeBtn[1].children[0].style.transform='skewY(45deg)';
	});
	
	//绗簩涓寜閽紝杩愬姩瀹屾垚锛屾坊鍔犳ā绯婃晥鏋�
	var num=0;
	freeBtn[1].addEventListener('transitionend',function(){
		num++;
		if(num==2){
			var arc=document.querySelectorAll(".arc");
			for(var i=2;i<sortBoxs.length;i++){
				sortBoxs[i].className+=' blur';
				arc[i].className+=' blur';
			}
		}
	});
}

//鍊掕鏃�
var dateInner=document.querySelector(".date div");
var targetDate=new Date(2016,11,12);
var dateSpans=document.querySelectorAll(".date span");
var oldStr='00澶�00鏃�00鍒�00绉�';
var endNum=0;

var timer=setInterval(function(){
	if(new Date()>targetDate){
		clearInterval(timer);
		return;
	}
	
	var result=cutDown(targetDate);
	var newStr=format(result.d)+'澶�'+format(result.h)+'鏃�'+format(result.m)+'鍒�'+format(result.s)+'绉�';
	
	for(var i=0;i<dateSpans.length;i++){
		if(dateSpans[i].className.indexOf('colon')==-1){
			dateSpans[i].className='';
		}
		
		if(oldStr.charAt(i)!=newStr.charAt(i)){
			dateSpans[i].innerHTML=newStr.charAt(i);
			dateSpans[i].className='active';
			
			dateSpans[i].addEventListener('transitionend',function(){
				this.className='';
			});
		}
	}
	
	oldStr=newStr;
	
},1000);

function format(s){
	return s<10?'0'+s:s+'';
}

function cutDown(target) {
    var currentDate=new Date();
    var v=Math.abs(target-currentDate);
    return {
        d:parseInt(v/(24*3600000)),
        h:parseInt(v%(24*3600000)/3600000),
        m:parseInt(v%(24*3600000)%3600000/60000),
        s:parseInt(v%(24*3600000)%3600000%60000/1000)
    }
}


//鍥炲埌椤堕儴鍔熻兘
back.onclick=function(){
	window.scrollTo(0,0);
};




//浣滃搧鍔熻兘
var workLis=document.querySelectorAll("#works li");
var shadow=document.getElementById('shadow');

var shadowBox=document.getElementById("shadowBox");
var showPic=document.getElementById("showPic");

var prev=document.querySelector("#showPic .prev");
var next=document.querySelector("#showPic .next");

var imgParent=document.querySelector(".img");
var workImgs=showPic.getElementsByTagName("img");
var workLink=document.querySelector("#showPic .img a");

var canClick=true;
var curNum=0;

var totalNum=workLis.length;

//鍥剧墖棰勫姞杞藉姛鑳藉嚱鏁�
function loadImg(imgArr,fn){
	var loadImgs=[],loadImgNum=0;
	for(var i=0;i<imgArr.length;i++){
		loadImgs[i]=new Image();
		loadImgs[i].onload=function(){
			loadImgNum++;
			if(loadImgNum==imgArr.length){
				fn(loadImgs);
			}
		}
		loadImgs[i].src=imgArr[i];
	}
}


//鍏堟妸鎵€鏈夊浘鐗囬兘瀛樺埌涓€涓暟缁勯噷
var imgArr=[];
for(var i=0;i<totalNum;i++){
	imgArr.push('work_images/work_'+i+'_big.jpg');
}

loadImg(imgArr,function(images){
	for(var i=0;i<workLis.length;i++){
		workLis[i].index=i;
		workLis[i].onclick=function(ev){
			shadowBox.style.height=document.body.offsetHeight+'px';
			shadowBox.style.display='block';
			showPic.style.display='block';
			
			
			setTimeout(function(){
				shadowBox.style.opacity=1;
				showPic.style.opacity=1;
				showPic.style.transform='scale(1)';
			},50);
			
			
			curNum=this.index;
			
			workImgs[1].src=images[curNum].src;		//寮瑰嚭灞傚嚭鏉ュ悗锛屽墠闈㈤偅寮犲浘搴旇鏄剧ず涓虹偣鍑荤殑閭ｅ紶鍥�
			workLink.href='work/'+(curNum+1)+'/index.html';//寮瑰嚭灞傚嚭鏉ュ悗锛屼慨鏀逛竴涓嬮摼鎺ュ湴鍧€
			workLink.target='_blank';
			
			
			nextClick(images);
			prevClick(images);
			
			ev.cancelBubble=true;
		};
	}
});

//鍥剧墖鐐瑰嚮锛岃烦杞摼鎺�
imgParent.onclick=function(ev){
	ev.cancelBubble=true;
}

//榧犳爣鐐瑰嚮鍏跺畠鍦版柟闅愯棌
document.addEventListener('click',function(){
	shadowBox.style.display='none';
	showPic.style.display='none';
	shadowBox.style.opacity=0;
	showPic.style.opacity=0;
	showPic.style.transform='scale(0)';
	
	workImgs[0].style.transform='translateX(0) rotateY(0)';
	workImgs[1].style.transform='rotateY(0)';
});

//涓嬩竴寮犵偣鍑�
function nextClick(images){
	var nextNum=0;
	
	next.onclick=function(ev){
		if(canClick){
			var endNum1=0;		//transitionend浼氳Е鍙戝娆★紝鎵€浠ョ敤涓や釜鍙橀噺鏉ヨ褰曞彂鐢熺殑娆℃暟
			var endNum2=0;
			
			nextNum=curNum+1;
			if(nextNum==totalNum){
				nextNum=0;
			}
			
			workImgs[0].src=images[nextNum].src;						//鏀瑰悗闈㈤偅寮犲浘鐨勫湴鍧€
			workImgs[0].className=workImgs[1].className='moveToRight';	//鏀逛袱寮犲浘鐨刢lass
			
			workImgs[1].style.transform='translateX(600px) rotateY(-10deg)';		//涓婇潰鐨勫浘寰€鍙宠蛋
			workImgs[1].addEventListener('transitionend',toRightEnd);				//鍒版渶鍙宠竟浜�
			function toRightEnd(){
				endNum1++;
				workImgs[0].style.transform='rotateY(-10deg)';				//涓嬮潰鍥剧墖寮犲紑
				workImgs[1].style.transform='translateX(0) rotateY(0)';		//涓婇潰鍥剧墖寰€宸﹁蛋
				
				//涓婇潰鍥剧墖鍥炲埌鍘熸潵浣嶇疆浜嗭紝涓嬮潰鍥剧墖杩樻病鏈夊悎涓�
				if(endNum1==2){
					workImgs[1].style.zIndex=1;			//涓婇潰鐨勫浘鐗囪窇鍚庨潰
					workImgs[0].style.zIndex=2;			//涓嬮潰鐨勫浘鐗囪窇鍓嶉潰
					workImgs[0].style.transform='rotateY(0)';		//涓嬮潰鍥剧墖鍚堜笂
				}
			}
			
			
			workImgs[0].addEventListener('transitionend',closeEnd);			//涔﹀悎涓婁簡
			function closeEnd(){
				endNum2++;
				if(endNum2==2){	//鎵€鏈夎繍鍔ㄩ兘璧板畬浜�
					curNum++;
					if(curNum==totalNum){
						curNum=0;
					}
					
					workImgs[0].style.zIndex=1;
					workImgs[1].style.zIndex=2;
					workImgs[1].src=images[nextNum].src;
					
					workLink.href='work/'+(nextNum+1)+'/index.html';//淇敼閾炬帴鍦板潃
					
					canClick=true;
				}
			}
		}
		
		canClick=false;
		ev.cancelBubble=true;
	};
}


//涓婁竴寮犵偣鍑�
function prevClick(images){
	var lastNum=0;
	
	prev.onclick=function(ev){
		if(canClick){
			var endNum1=0;		//transitionend浼氳Е鍙戝娆★紝鎵€浠ョ敤涓や釜鍙橀噺鏉ヨ褰曞彂鐢熺殑娆℃暟
			var endNum2=0;
			
			prevNum=curNum-1;
			if(prevNum==-1){
				prevNum=totalNum-1;
			}
			
			workImgs[0].src=images[prevNum].src;						//鏀瑰悗闈㈤偅寮犲浘鐨勫湴鍧€
			workImgs[0].className=workImgs[1].className='moveToLeft';	//鏀逛袱寮犲浘鐨刢lass
			
			workImgs[1].style.transform='translateX(-600px) rotateY(10deg)';		//涓婇潰鐨勫浘寰€鍙宠蛋
			workImgs[1].addEventListener('transitionend',toRightEnd);				//鍒版渶鍙宠竟浜�
			function toRightEnd(){
				endNum1++;
				workImgs[0].style.transform='rotateY(10deg)';				//涓嬮潰鍥剧墖寮犲紑
				workImgs[1].style.transform='translateX(0) rotateY(0)';		//涓婇潰鍥剧墖寰€宸﹁蛋
				
				//涓婇潰鍥剧墖鍥炲埌鍘熸潵浣嶇疆浜嗭紝涓嬮潰鍥剧墖杩樻病鏈夊悎涓�
				if(endNum1==2){
					workImgs[1].style.zIndex=1;			//涓婇潰鐨勫浘鐗囪窇鍚庨潰
					workImgs[0].style.zIndex=2;			//涓嬮潰鐨勫浘鐗囪窇鍓嶉潰
					workImgs[0].style.transform='rotateY(0)';		//涓嬮潰鍥剧墖鍚堜笂
				}
			}
			
			
			workImgs[0].addEventListener('transitionend',closeEnd);			//涔﹀悎涓婁簡
			function closeEnd(){
				endNum2++;
				if(endNum2==2){	//鎵€鏈夎繍鍔ㄩ兘璧板畬浜�
					curNum--;
					if(curNum==-1){
						curNum=totalNum-1;
					}
					
					workImgs[0].style.zIndex=1;
					workImgs[1].style.zIndex=2;
					workImgs[1].src=images[prevNum].src;
					workLink.href='work/'+(prevNum+1)+'/index.html';//淇敼閾炬帴鍦板潃
					
					canClick=true;
				}
			}
		}
		
		canClick=false;
		ev.cancelBubble=true;
	};
}


//婊氬姩鏂囧瓧鍖哄煙
var scrollText=document.querySelector(".scrollText");
var scrollUl=scrollText.querySelector('ul');
var scrollLi=scrollUl.getElementsByTagName('li');
var scrollSpan=scrollText.querySelectorAll('span');
var scrollTimer;
var canScroll=true;

scrollText.onmouseover=function(){
	clearInterval(scrollTimer);
}
scrollText.onmouseout=autoScroll;

scrollSpan[0].onclick=scrollPrev;
scrollSpan[1].onclick=scrollNext;

autoScroll();
function autoScroll(){
	scrollTimer=setInterval(scrollNext,3000);
}

function scrollNext(){
	if(!canScroll){
		return;
	}
	canScroll=false;
	
	move(scrollUl,{top:-50},300,'linear',function(){
		scrollUl.appendChild(scrollLi[0]);
		scrollUl.style.top=0;
		canScroll=true;
	});
};

function scrollPrev(){
	if(!canScroll){
		return;
	}
	canScroll=false;
	
	scrollUl.insertBefore(scrollLi[scrollLi.length-1],scrollLi[0]);
	scrollUl.style.top='-50px';
	
	move(scrollUl,{top:0},300,'linear',function(){
		canScroll=true;
	});
};
