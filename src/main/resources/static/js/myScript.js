$('#menu ul li').bind('click',
  function() {
    var menuList = $('#menu ul li');
    for(var i = 0; i <= menuList.length; i++){
      menuList.eq(i).css("background-color","#323436");
      menuList.eq(i).children("a").css("border-left-color","#1d1d1d");
    }
    $(this).css("background-color","#1d1d1d");
    $(this).children("a").css("border-left-color","#00cdcd");
});

$('.menu_back a').bind('click',
    function() {
        $(window.parent.document).attr("title","云辉相映");
        $(window.parent.document).find("#newwrap").css("visibility","hidden");
    });

