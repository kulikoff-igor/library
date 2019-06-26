
let role = [];

$(document).ready(function () {

    $('#registerUser').click(function () {


        if ($('#adminRole').prop( "checked" )) {

            role.push( "ADMIN");
        }
        if ($('#userRole').prop( "checked" )) {

            role.push( "USER");
        }
        //console.log(role.toString());
        $.ajax({
            url: "/library/api/user/add",
            type: "POST",
            async: false,
            dataType: "json",
            data: {
                login: $('#Login').val(),
                password: $('#password').val(),
                address: $('#address').val(),
                name: $('#name').val(),
                lastName: $('#lastName').val(),
                library: $('#library').val(),
                role:role.toString()
            }
            ,
            success: function (data) {
                console.log(data.toString());
            }
        });
        role = [];
    })
});
