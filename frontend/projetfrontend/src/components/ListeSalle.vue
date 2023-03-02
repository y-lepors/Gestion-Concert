<script setup>
	import Salle from "/src/components/Salle.vue";
	import AsideSalle from "/src/components/AsideSalle.vue";
</script>

<script>
export default {
	data() {
		return {
			currentSalle: -1,
			salles: [
				{ id: 1, nomSalle: "salle1" },
				{ id: 2, nomSalle: "salle2" },
				{ id: 3, nomSalle: "salle3" },
				{ id: 4, nomSalle: "salle4" },
				{ id: 5, nomSalle: "salle5" },
				{ id: 6, nomSalle: "salle6" },
				{ id: 7, nomSalle: "salle7" },
				{ id: 8, nomSalle: "salle8" },
				{ id: 9, nomSalle: "salle9" },
				{ id: 10, nomSalle: "test1" },
				{ id: 11, nomSalle: "test1" },
				{ id: 12, nomSalle: "test1" },
				{ id: 13, nomSalle: "test1" },
				{ id: 14, nomSalle: "test1" },
				{ id: 15, nomSalle: "test1" },
			],
		};
	},
	methods: {
		setAsideSalle(val) {
			if(this.currentSalle == val)
				this.currentSalle = -1;
			else
				this.currentSalle = val;
			console.log(this.salles.find((salle) => salle.id == val).nomSalle);
		},
	}
};
</script>

<template>

	<div class="parMain">

		<div class="listeSalle">
			<Salle v-for="salle in salles" :idSalle="salle.id" @click="setAsideSalle(salle.id)"/>
		</div>

		<!-- l'attribut key force la MAJ au changement de valeur -->
		<AsideSalle :idSalle="currentSalle" :key="currentSalle"/>
	</div>
	
</template>
