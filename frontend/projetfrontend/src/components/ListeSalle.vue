<script setup>
	import Salle from "/src/components/Salle.vue";
	import AsideSalle from "/src/components/AsideSalle.vue";
</script>

<script>
export default {
	data() {
		return {
			currentSalleID: -1,
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
