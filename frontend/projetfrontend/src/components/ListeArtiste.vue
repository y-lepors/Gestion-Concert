<script setup>

import Artiste from "/src/components/Artiste.vue";
import AsideArtiste from "/src/components/AsideArtiste.vue";

</script>

<script>

	export default {
		data() {
			return {
				artistes: [],
				currentArtisteID: -1,
			};
		},
		methods: {
			setAsideArtiste(id) {
				this.currentArtisteID = id;
			},
		},
		created() {
			fetch('http://localhost:8082/Servlet_war_exploded/getAllArtiste')
				.then(response => response.json())
				.then(data => {
					this.artistes = data;
				});
		},
	}

</script>


<template>
	<div class="parMain">

	<div class="listeSalle">
		<!-- <Salle v-for="salle in salles" :idSalle="salle.idSalle" @click="setAsideSalle(salle.id)"/> -->
		<Artiste v-for="artiste in artistes" :nomArtiste="artiste.nom" @click="setAsideArtiste(artiste.id)"/>
	</div>

	<!-- l'attribut key force la MAJ au changement de valeur -->
	<!-- <AsideSalle :idSalle="currentSalleID" :key="currentSalleID"/> -->
	<AsideArtiste :idArtiste="currentArtisteID" :key="currentArtisteID"/>
	</div>
</template>