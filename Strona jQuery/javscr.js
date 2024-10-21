$(document).ready(function() {

$("h1").text("Zadanie z jQuery");

$("#colorBtn").click(function(){ 
    var randomColor = '#' + Math.floor(Math.random()*16777215).toString(16);
        $("body").css("background-color", randomColor); 
});

$("#showDateBtn").click(function() {
    const data = new Date().toLocaleString();
    $("#date").text("data: " + data);
});

$("p").addClass("highlight");

$("#image").attr("src", "https://p16-va.lemon8cdn.com/tos-maliva-v-ac5634-us/ogFjQkAMIE8xaHAFeyVW7DEIeQfZknAfAPsFD2~tplv-tej9nj120t-origin.webp").hide();

$("#toggleImageBtn").click(function() {
    $("#image").fadeToggle();
});

$("#slideTextBtn").click(function() {
    $("#textSection").slideToggle();
});

$("#addParaBtn").click(function() {
    $("#content").append("<p>Nowy paragraf</p>");
});

$("#removeParaBtn").click(function() {
    $("#content p:last").remove();
});


});
