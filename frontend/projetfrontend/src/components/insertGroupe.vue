<template>
    <h1>Ajouter un groupe</h1>
  
    <form id="myForm">
      <label for="nom">Nom</label>
      <input type="text" name="nom" id="nom" required><br/>
  
      <input type="submit" value="Ajouter">
    </form>
  
    <div id="successMessage" style="display:none;color: green;">
      Groupe ajouté avec succès !
    </div>

  </template>
  
  <script>
  import $ from 'jquery';
  
  export default {
    mounted() {
      // On écoute l'événement submit du formulaire
      $('#myForm').submit(function(event) {
        // On empêche le comportement par défaut qui est de recharger la page
        event.preventDefault();
  
        // On récupère les données du formulaire
        const formData = $(this).serialize();
  
        // On envoie une requête AJAX pour soumettre le formulaire
        $.ajax({
          type: 'POST',
          url: 'http://localhost:8082/Servlet_war_exploded/insertGroupe',
          data: formData,
          success: function(response) {
            // On cache le formulaire et on affiche le message de succès
            $('#successMessage').show();
          },
          error: function(jqXHR, textStatus, errorThrown) {
            console.error('Une erreur est survenue :', textStatus, errorThrown);
          }
        });
      });
    }
  };
  </script>
  