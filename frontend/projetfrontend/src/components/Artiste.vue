<script>
export default {
	props: {
		// idSalle: Number,
        nomArtiste: String,
	},
    data() {
		return {
			// idS: parseInt(this.idSalle),
			nomA: this.nomArtiste,
		};
	}
};
</script>

<template>
    <div class="salle">
        <h1>{{ nomA }}</h1>
    </div>
</template>