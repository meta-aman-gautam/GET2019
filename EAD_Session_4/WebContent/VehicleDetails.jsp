<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Vehicle Detail Form</title>
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
    <div id="2" align="center">
        <form action="VehicleDetails" method="GET">
            <h2> vehicle details </h2>
            <table>
                <tr>
                    <td>Vehicle Name :</td>
                    <td><input type="text" placeholder="Please enter vehicle name" name="vehiclename"></td>
                </tr>
                <tr>
                    <td> type : </td>
                    <td> <select id="selectType" name="selectType">
                            <option value="" selected disabled hidden>Choose here</option>
                            <option value="Cycle">Cycle</option>
                            <option value="MotorCycle">MotorCycle</option>
                            <option value="Four Wheelers">Four Wheelers</option>
                        </select> </td>
                </tr>
                <tr>
                    <td>Vehicle Number :</td>
                    <td><input type="text" placeholder="Vehicle number" name="vehiclenumber"></td>

                </tr>
                <tr>
                    <td>Emplopye Id :</td>
                    <td><input type="text" placeholder="Employe Id" name="employeId"
                            value=<%= session.getAttribute("empId") %> readonly></td>
                </tr>
                <tr>
                    <td>Identification :</td>
                    <td><textarea rows="4" cols="50" name="identification">

                                </textarea></td>
                </tr>
                <tr>
                    <td align="center" colspan="2"><input type="submit" id="register" value="register"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>