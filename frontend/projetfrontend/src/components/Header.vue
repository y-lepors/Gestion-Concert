<script>
export default {
	props: {
		page: Number,
	},
	data() {
		return {
			currentPage: parseInt(this.page),
		};
	},
	methods: {
		setPage(val) {
			this.currentPage = val;
		},
	},
	emits: ["response"],
	watch: {
		currentPage: function (newPage) {
			this.$emit("response", newPage);
		}
	},
};
</script>

<template>
	<div class="header">
		<div @click="setPage(1)">1</div>
		<div @click="setPage(2)">2</div>
	</div>

	<h2>Numéro de page : {{ currentPage }}</h2>
</template>
