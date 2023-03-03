<script setup>
import Header from "./components/Header.vue";
import Footer from "./components/Footer.vue";
import ListeSalle from "./components/ListeSalle.vue";
import ListeArtiste from "./components/ListeArtiste.vue";

import insertArtiste from "./components/insertArtiste.vue";

</script>

<script>
export default {
	
	data() {
		return {
			currentPage: 3,
			isAdmin: localStorage.getItem('isAdmin') === 'true' ? true : false,
		};
	},
	methods: {
		updateAdmin() {
			this.isAdmin = localStorage.getItem('isAdmin') === 'true' ? true : false;
		},
		
	},
}
</script>

<template>
	<header>
		<Header :page="3" @response="(msg) => currentPage = msg" />
	</header>

	<main>
		<div v-if="currentPage == 1">
			<ListeSalle />
		</div>
		<div v-if="currentPage == 2">
			<ListeArtiste />
		</div>
		<div v-if="currentPage == 3">
			<insertArtiste />
		</div>
	</main>

	<footer>
		<Footer @response="(msg) => updateAdmin"/>
	</footer>
</template>