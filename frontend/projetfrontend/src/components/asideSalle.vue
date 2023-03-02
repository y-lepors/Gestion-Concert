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
		};
	},
	created() {
		if(this.idS == -1) return;
		fetch("http://localhost:8080/salles/"+this.idS)
			.then((response) => response.json())
			.then((json) => { this.salle = json; });
			// .then(() => console.log("aside : ",this.salle));
	},
};

</script>

<template>
    <div id="asideSalle" v-if="this.salle != null">
		<h1 id="nomSalle">{{ salle.nom }}</h1>
		<div class="infoSalle">
			<p>{{ salle.adresse }}</p>
        	<p>Capacité : {{ salle.capacite }}</p>
			<p>Gestionnaire : {{ salle.gestionnaire.nom }} <span v-if="salle.gestionnaire.nom != salle.gestionnaire.president">- {{ salle.gestionnaire.president }}</span></p>
		</div>
		
		<h2>Liste des concerts</h2>
		<div class="listeConcerts">
			
		</div>
		
	</div>
</template>