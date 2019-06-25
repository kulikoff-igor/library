let user = {
    userId: null,
    login: null,
    password: null,
    userDescription: null,
    library: null,
    roles: null
};

let userDescription = {
    name: null,
    lastName: null,
    address: null
};
let role = [];

$(document).ready(function () {

    $('#registerUser').click(function () {

        user.login = $('#Login').val();
        user.password = $('#password').val();
        userDescription.address = $('#address').val();
        userDescription.name = $('#name').val();
        userDescription.lastName = $('#lastName').val();
        user.userDescription = userDescription;
        if ($('#adminRole').attr("checked") == 'checked') {
            role[0] = "ADMIN";
        }
        if ($('#userRole').attr("checked") == 'checked') {
            role[0] = "USER";
        }
        //console.log(JSON.stringify(user));
        $.ajax({
            url: "/library/api/user/add",
            type: "POST",
            dataType: "json",
            data: {
                User: JSON.stringify(user),
                roleUser: role
            },
            success: function (data) {
                console.log(data.toString());
            }
        });
    })
});
