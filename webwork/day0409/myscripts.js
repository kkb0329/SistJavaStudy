window.onload=function(){


let mycar=document.querySelectorAll(".mycar");

var p="";

        

    mycar[0].onmouseover = function () {
         p=this.getAttribute("src");
        this.setAttribute("src","../mycar/mycar1.png")
    };

    mycar[0].onmouseout = function () {
        this.setAttribute("src",p)
    };



    mycar[1].onmouseover = function () {
        this.style.borderStyle="inset";
        this.style.borderWidth="10px";
        this.style.borderColor="pink";
   };

   mycar[1].onmouseout = function () {
    this.style.borderStyle="none";
   };


   mycar[2].onmouseover = function () {
    this.className="happy";
};

mycar[2].onmouseout = function () {
    this.className="mycar";
};



}