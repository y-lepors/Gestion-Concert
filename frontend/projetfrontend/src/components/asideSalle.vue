<script>
export default {
	props: {
		idSalle: Number,
        required: true,
	},
    data() {
		return {
			idS: parseInt(this.idSalle),
		};
	},
};

</script>

<template>
    <div id="asideSalle" v-if="this.idS != -1">
        <h1>Aside Salle {{ idS }}</h1>
	</div>
</template>