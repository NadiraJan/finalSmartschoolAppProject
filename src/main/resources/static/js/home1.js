var rightButtonFacaParte = document.getElementById("faca-parte");

if(rightButtonFacaParte != null){


  rightButtonFacaParte.addEventListener('mouseleave', ()=>{
    setTimeout(()=>{
      rightButtonFacaParte.style['z-index'] = '0';
    },1000);
  }, false);

  rightButtonFacaParte.addEventListener('mouseenter', ()=>{
    rightButtonFacaParte.style['z-index'] = '2';
  }, false);
}