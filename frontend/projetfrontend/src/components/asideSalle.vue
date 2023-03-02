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
    beforeMount() {
        if(this.idS == -1)
            this.$router.push({ name: "ListeSalle" }
        console.log("testBefore");
        console.log(this.idS);
    },
};
</script>

<template>
    <h1>Aside Salle {{ idS }}</h1>
    <!-- <p>vide ? : {{ vide }}</p> -->
</template>