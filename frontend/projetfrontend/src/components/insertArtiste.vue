<script setup>
</script>


<template>

    <h1>Ajouter un artiste</h1>

    <form action="http://localhost:8082/Servlet_war_exploded/insertArtiste" method="post">
        <label for="nom">Nom de l'artiste</label>
        <input type="text" name="nom" id="nom" required>
        <input type="submit" value="Ajouter">
    </form>


</template>