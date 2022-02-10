/*$(document).ready(function() {
    $('#example').DataTable();
} );*/


$(document).ready(function () {
$('#dtDynamicVerticalScrollExample').DataTable({
"scrollY": "50vh",
"scrollCollapse": true,
});
$('.dataTables_length').addClass('bs-select');
});