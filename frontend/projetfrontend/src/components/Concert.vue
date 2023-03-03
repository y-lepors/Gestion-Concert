<script>
export default {
	props: {
        idConcert: Number,
		capacite: Number,
	},
    data() {
		return {
			idC: parseInt(this.idConcert),
			cap: parseInt(this.capacite),
			concert: null,
		};
	},
	created() {
		if(this.idC == -1) return;
		fetch("http://localhost:8080/concerts/"+this.idC)
			.then((response) => response.json())
			.then((json) => { this.concert = json; });
	},
};
</script>

<template>
    <div class="concert"
     v-if="concert != null"
     v-bind:class="(new Date(concert.dateConcert).getTime() > Date.now()) ? 'concertFutur' : 'concertPasse'">
		<h2>Concert du {{ concert.dateConcert }}</h2>
		<div>{{ concert.nbPlaces }} / {{ cap }}</div>
        
    </div>
</template>