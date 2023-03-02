<script setup>
	import Salle from "/src/components/Salle.vue";
	import AsideSalle from "/src/components/AsideSalle.vue";
</script>

<script>
export default {
	data() {
		return {
			currentSalleID: -1,
			// salles: [
			// 	{ id: 1, nomSalle: "salle1" },
			// 	{ id: 2, nomSalle: "salle2" },
			// 	{ id: 3, nomSalle: "salle3" },
			// 	{ id: 4, nomSalle: "salle4" },
			// 	{ id: 5, nomSalle: "salle5" },
			// 	{ id: 6, nomSalle: "salle6" },
			// 	{ id: 7, nomSalle: "salle7" },
			// 	{ id: 8, nomSalle: "salle8" },
			// 	{ id: 9, nomSalle: "salle9" },
			// 	{ id: 10, nomSalle: "test1" },
			// 	{ id: 11, nomSalle: "test1" },
			// 	{ id: 12, nomSalle: "test1" },
			// 	{ id: 13, nomSalle: "test1" },
			// 	{ id: 14, nomSalle: "test1" },
			// 	{ id: 15, nomSalle: "test1" },
			// ],
			salles: [],
		};
	},
	methods: {
		setAsideSalle(val) {
			if(this.currentSalleID == val){
				this.currentSalleID = -1;
			}else{
				this.currentSalleID = val;
			}
		},

	},
	created() {
		fetch("http://localhost:8080/salles/")
			.then((response) => response.json())
			.then((json) => { this.salles = json; });
			// .then(() => console.log("Les salles : ",this.salles));
	},
};

</script>

<template>

	<div class="parMain">

		<div class="listeSalle">
			<!-- <Salle v-for="salle in salles" :idSalle="salle.idSalle" @click="setAsideSalle(salle.id)"/> -->
			<Salle v-for="salle in salles" :nomSalle="salle.nom" @click="setAsideSalle(salle.idSalle)"/>
		</div>

		<!-- l'attribut key force la MAJ au changement de valeur -->
		<AsideSalle :idSalle="currentSalleID" :key="currentSalleID"/>
	</div>
	
</template>
