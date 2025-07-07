/**
 * 
 */
 $(function(){
    $("#myimg").attr("src","../image/logoImg/a.png");
    
    
    $("#myimg").hover(function(){
    
        $(this).attr("src","../image/logoImg/a01.png");
    },function(){
       $(this).attr("src","../image/logoImg/a.png");
    });
    
 });