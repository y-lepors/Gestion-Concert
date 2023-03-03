<script setup>
	import Concert from "/src/components/Concert.vue";
</script>

<script>
export default {
	props: {
		idSalle: Number,
        required: true,
	},
    data() {
		return {
			idS: parseInt(this.idSalle),
			salle: null,
			concerts: null,
			adresse: null,
			src: null,
		};
	},
	created() {
		if(this.idS == -1) return;
		fetch("http://localhost:8080/salles/"+this.idS)
			.then((response) => response.json())
			.then((json) => { this.salle = json; })
			.then(() => this.adresse = this.salle.adresse.replaceAll(" ","%20"))
			.then(() => this.src = "https://maps.google.com/maps?q="+this.adresse+"+()&amp;output=embed");
			// .then(() => console.log("aside : ",this.salle));
	},
};

</script>

<template>
    <div id="asideSalle" v-if="this.salle != null">
		
		<h1 id="nomSalle">{{ salle.nom }}</h1>
		<div class="infoSalle">
			<p>{{ salle.adresse }}</p>
			<p>{{ salle.capacite }}</p>
			<!-- <iframe width="100%" height="600" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src={{ this.src }}></iframe> -->
			<p>Gestionnaire : {{ salle.gestionnaire.nom }} <span v-if="salle.gestionnaire.nom != salle.gestionnaire.president">- {{ salle.gestionnaire.president }}</span></p>
		</div>
		
		<h2>Liste des concerts</h2>
		<div class="listeConcerts">
			<Concert v-for="concert in salle.concerts" :idConcert="concert.idConcert" :capacite="salle.capacite"/>
		</div>
		
	</div>
</template>