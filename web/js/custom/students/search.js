$("#searchbatch").change(function () {
    let v = this.value;
    $("#srh1").val(v);
  $("#form1").submit();

});
$("#searchStatus").change(function () {
    let v1 = this.value;
    $("#srh2").val(v1);
    $("#form2").submit();

});
$("#search").change(function () {
    let v2 = this.value;
    $("#srh3").val(v2);
    $("#form3").submit();

});