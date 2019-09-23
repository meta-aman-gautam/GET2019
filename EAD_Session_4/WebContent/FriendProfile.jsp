<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Friend Profile</title>

    <style>
        td {
            padding: 15px;
        }

        textarea {
            width: 175px;
        }
    </style>
</head>

<body>
    <div align="center">
        <h1> <%= request.getAttribute("fullName") %> Profile </h1>
        <table>
            <tr>
                <td>Full Name :</td>
                <td>
                    <%= request.getAttribute("fullName") %>

                </td>
            </tr>

            <tr>
                <td>Email :</td>
                <td>
                    <%= request.getAttribute("email") %>
                </td>

            </tr>
            <tr>
                <td>Contact No. :</td>
                <td>
                    <%= request.getAttribute("contact_number")%>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="FriendList">Click Hear</a> to go back
                </td>
            </tr>
        </table>
    </div>
</body>

</html>