<script>
export default {
	props: {
		idArtiste: Number,
        required: true,
	},
    data() {
		return {
			idA: parseInt(this.idArtiste),
			artiste: null,
			concerts: null,
		};
	},
	created() {
		if(this.idA == -1) return;
		fetch("http://localhost:8082/Servlet_war_exploded/getArtisteById?id="+this.idA)
			.then((response) => response.json())
			.then((json) => { this.artiste = json; });
			// .then(() => console.log("aside : ",this.salle));
		fetch("http://localhost:8080/concerts/")
			.then((response) => response.json())
			.then((json) => { this.concerts = json; });
	},
	methods: {
		getDateConcert(id) {
			let c = this.concerts.find(concert => concert.idConcert == id);
			return c.dateConcert;
		}

	}
};

</script>

<template>
    <div id="asideSalle" v-if="this.artiste != null">
		<h1 id="nomSalle">{{ artiste.nom }}</h1>
		<div class="infoSalle">
			<p>Nom : {{ artiste.nom }}</p>
            <p>Prénom : {{ artiste.prenom }}</p>
            <p>Pseudo : {{ artiste.pseudo }}</p>
            <p>age : {{ artiste.age }}</p>
		</div>
		
		<h2>Liste des concerts</h2>
		<div class="listeConcerts">

			<!-- Affiche tout les concert lié à un id de artiste.concertSet.id trouver dans le fetch concerts -->



			<div v-for="concert in artiste.concertSet" :key="concert.id">
				<p>Date de concert : {{ getDateConcert(concert.id) }} </p>
			</div>
		</div>	
		
	</div>
</template>