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

        input, button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #555;
        }

        input {
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
        <h1>Ajouter un nouveau credit</h1>
        <form action="ajout-credit" method="post">
            <label for="libelle">Libelle du credit :</label><br>
            <input type="text" id="libelle" name="libelle" required><br><br>
            <label for="montant">Montant du credit :</label><br>
            <input type="number" id="montant" name="montant" min="0"required><br><br>
            <button type="submit">Ajouter</button>
        </form>
    </div>
</body>
</html>
