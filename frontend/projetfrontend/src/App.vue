<script setup>
import Header from "./components/Header.vue";
import ListeSalle from "./components/ListeSalle.vue";
import ListeArtiste from "./components/ListeArtiste.vue";
import Footer from "./components/Footer.vue";
</script>

<script>
export default {
	data() {
		return {
			currentPage: 1,
		};
	}
}
</script>

<template>
	<header>
		<Header :page="1" @response="(msg) => currentPage = msg" />
	</header>

	<main>
		<div v-if="currentPage == 1">
			<ListeSalle />
		</div>
		<div v-if="currentPage == 2">
			<ListeArtiste />
		</div>
	</main>

	<footer>
		<Footer />
	</footer>
</template>