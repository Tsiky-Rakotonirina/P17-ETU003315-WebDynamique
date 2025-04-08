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
            font-family: Arial, sans-serif; /* Police de caractères améliorée */
        }
        .button-container {
            display: flex;
            gap: 40px; /* Espacement augmenté entre les boutons */
        }
        .button-container a {
            display: block;
            width: 20vw; /* Taille des boutons augmentée */
            height: 15vh;
            background-color: #333; /* Couleur de fond noire */
            color: white;
            text-align: center;
            line-height: 150px; /* Centrer le texte dans le bouton */
            text-decoration: none;
            font-weight: bold;
            font-size: 18px; /* Taille de la police augmentée */
            border-radius: 12px; /* Bord arrondi plus marqué */
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.3); /* Ombre plus prononcée */
            transition: background-color 0.3s, transform 0.3s, box-shadow 0.3s;
        }
        .button-container a:hover {
            background-color: #555; /* Nuance plus claire au survol */
            transform: scale(1.1); /* Effet de zoom au survol */
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.4); /* Ombre plus marquée au survol */
        }
        .button-container a:active {
            background-color: #222; /* Nuance encore plus foncée lorsqu'on clique */
            transform: scale(1); /* Suppression de l'effet de zoom pendant le clic */
        }
    </style>
</head>
<body>
    <div class="button-container">
        <a href="form-credit">Ajout de Credit</a>
        <a href="form-depense">Ajout de depense</a>
        <a href="list-depense">Liste des depenses</a>
        <a href="login.jsp">Login: necessaire pour des trasanctions</a>
    </div>
</body>
</html>
