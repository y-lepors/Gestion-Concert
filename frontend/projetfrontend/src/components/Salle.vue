<script>
export default {
	props: {
		// idSalle: Number,
        nomSalle: String,
	},
    data() {
		return {
			// idS: parseInt(this.idSalle),
			nomS: this.nomSalle,
		};
	}
};
</script>

<template>
    <div class="salle">
        <h1>{{ nomS }}</h1>
    </div>
</template>