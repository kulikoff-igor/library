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
        if ($('#adminRole').checkbox()) {
            role[0] = "ADMIN";
        }
        if ($('#userRole').checkbox()) {
            role[0] = "USER";
        }

        $.ajax({
            url: "/user/add",
            type: "Get",
            dataType: "json",
            data: {
                User: user,
                roleUser: role
            },
            success: function (data) {
                console.log(data.toString());
            }
        });
    })
});
