<script>
export default {
	props: {
		page: Number,
	},
	data() {
		return {
			currentPage: parseInt(this.page),
			isAdmin: localStorage.getItem('isAdmin') === 'true' ? true : false,
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
		<div @click="setPage(1)">Salles de concert</div>
		<div @click="setPage(2)">Artistes</div>
		<div v-if="isAdmin" @click="setPage(3)">Admin</div>
	</div>

</template>
