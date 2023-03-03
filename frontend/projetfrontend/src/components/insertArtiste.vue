<!-- <script setup>
</script>


<template>

    <h1>Ajouter un artiste</h1>

    <form action="http://localhost:8082/Servlet_war_exploded/insertArtiste" method="post">
        <label for="nom">Nom</label>
        <input type="text" name="nom" id="nom" required><br/>
        <label for="prenom">Prénom</label>
        <input type="text" name="prenom" id="prenom" required><br/>
        <label for="pseudo">Pseudo</label>
        <input type="text" name="pseudo" id="pseudo" required><br/>
        <label for="ville">Ville</label>
        <input type="text" name="ville" id="ville" required><br/>
        <label for="age">Age</label>
        <input type="number" name="age" id="age" required><br/>


        <input type="submit" value="Ajouter">
    </form>


</template> -->

<template>
    <h1>Ajouter un artiste</h1>
  
    <form id="myForm">
      <label for="nom">Nom</label>
      <input type="text" name="nom" id="nom" required><br/>
      <label for="prenom">Prénom</label>
      <input type="text" name="prenom" id="prenom" required><br/>
      <label for="pseudo">Pseudo</label>
      <input type="text" name="pseudo" id="pseudo" required><br/>
      <label for="ville">Ville</label>
      <input type="text" name="ville" id="ville" required><br/>
      <label for="age">Age</label>
      <input type="number" name="age" id="age" required><br/>
  
      <input type="submit" value="Ajouter">
    </form>
  
    <div id="successMessage" style="display:none;color: green;">
      Artiste ajouté avec succès !
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
          url: 'http://localhost:8082/Servlet_war_exploded/insertArtiste',
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
  