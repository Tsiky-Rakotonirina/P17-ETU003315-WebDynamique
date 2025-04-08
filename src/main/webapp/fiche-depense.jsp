<%@ page import="model.entites.Credit" %> 
<%@ page import="model.utils.BaseObject" %>
<%@ page import="model.entites.Depense" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<BaseObject> departements =  (ArrayList<BaseObject>) request.getAttribute("credits"); %>
<% BaseObject baseObject =  (BaseObject) request.getAttribute("depense"); %>
<% Depense employe =  (Depense) baseObject; %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Emploi</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
            margin: 0;
            font-family: Arial, sans-serif;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            background-color: #333;
            padding: 30px;
            border-radius: 8px;
            width: 300px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        label {
            color: white;
            font-weight: bold;
        }

        input, select, button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #555;
        }

        input, select {
            background-color: #444;
            color: white;
        }

        button {
            background-color: #333;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.3s;
        }

        button:hover {
            background-color: #555;
            transform: scale(1.05);
        }

        button:active {
            background-color: #222;
        }
    </style>
</head>
<body>
    <div>
        <h1>Ajouter un nouveau depense</h1>
        <form action="modifier-employe" method="post">
            <input type="hidden" id="id" name="updateId" value ="<%= employe.getId() %>"><br>

            <label for="nom">Nom de l'Depense :</label>
            <input type="text" id="nom" name="nom" placeholder="Ex : Pierre" value ="<%= employe.getNom() %>" ><br>

            <label for="departement">Credit de l'Depense :</label>
            <select id="departement" name="departement">
                <% for(BaseObject base : departements) { 
                    Credit departement = (Credit) base;
                    if(departement.getId() == employe.getCredit_id()) {
                %>
                    <option value="<%= departement.getId() %>" selected><%= departement.getNom() %></option>
                <% } else { %>
                    <option value="<%= departement.getId() %>"><%= departement.getNom() %></option>
                <% } } %>
            </select><br>

            <button type="submit">Modifer</button>
        </form>
    </div>
</body>
</html>
