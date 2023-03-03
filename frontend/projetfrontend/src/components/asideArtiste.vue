<script setup>
	import Concert from "/src/components/Concert.vue";
</script>

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
			imgOrArticle: null,
			imgSalle: [],
			imgConcert: [],
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

		fetch("http://localhost:8082/Servlet_war_exploded/getImgOrArticle")
			.then((response) => response.json())
			.then((json) => { this.imgOrArticle = json; });
			// .then(() => console.log(this.imgOrArticle))
	},
	methods: {
		getDateConcert(id) {
			let c = this.concerts.find(concert => concert.idConcert == id);
			return c.dateConcert;
		},
		openModale(id){
			this.setImgConcert(id);
			document.getElementsByClassName("modaleConcert")[0].classList.toggle("hideModal");
			console.log("open modale concert "+id);
		},
		getCapacite(id) {
			let c = this.concerts.find(concert => concert.idConcert == id);
			console.log(c);
			return c.salle.capacite;
		},
		setImgConcert(idConcert){
			this.imgConcert = [];
			for(let i = 0; i < this.imgOrArticle.length; i++){
				if(this.imgOrArticle[i].Lier.Concert.indexOf(idConcert.toString()) !=-1){
					this.imgConcert.push(this.imgOrArticle[i]);
				}
			}
			console.log(this.imgConcert);
		},
		setImgSalle(idSal) {
			this.imgSalle = [];
			for(let i = 0; i < this.imgOrArticle.length; i++){
				if(this.imgOrArticle[i].Lier.Salle.indexOf(idSal.toString()) !=-1){
					this.imgSalle.push(this.imgOrArticle[i]);
				}
			}
			console.log(this.imgSalle);
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
				
				<Concert :idConcert="concert.id" :capacite="getCapacite(concert.id)" @click="openModale(concert.id)"/>
			</div>

			
		</div>	

		<div class="modaleConcert">
		<img v-for="img in imgConcert" :src="img.Url"/>
		</div>
		
	</div>
</template>