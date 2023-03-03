<script setup>
	// import Artiste from "/src/components/Artiste.vue";
	// import AsideArtiste from "/src/components/AsideArtiste.vue";
</script>

<script>
export default {
	data() {
		return {
			currentArtisteID: -1,
			artistes: [],
		};
	},
	methods: {
		setAsideArtiste(val) {
			if(this.currentArtisteID == val){
				this.currentArtisteID = -1;
			}else{
				this.currentArtisteID = val;
			}
		},

	},
	created() {
		fetch("http://localhost:8082/Servlet_war_exploded/getAllArtiste")
			.then((response) => response.json())
			.then((json) => { this.artistes = json; })
			.then(() => console.log("Les artistes : ",this.artistes));
	},
};

</script>

<template>

	<div class="parMain">

		<div class="listeArtiste">
		</div>

	</div>
	
</template>
