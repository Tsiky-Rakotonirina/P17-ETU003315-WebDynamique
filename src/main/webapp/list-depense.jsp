<%@ page import="model.entites.Depense" %> 
<%@ page import="model.utils.BaseObject" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<BaseObject> depenses = (ArrayList<BaseObject>) request.getAttribute("depenses"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Emploi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <div>
        <h1>Liste des Depenses</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Credit</th>
                    <th>Date</th>
                    <th>Montant</th>
                    
                </tr>
            </thead>
            <tbody>
                <% for (BaseObject base : depenses) { 
                    Depense depense = (Depense) base;
                %>
                    <tr>
                        <td><%= depense.getId() %></td>
                        <td><%= depense.getIdCredit() %></td>
                        <td><%= depense.getDate() %></td>
                        <td><%= depense.getMontant() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
