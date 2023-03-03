<script>
export default {
    data() {
		return {
			isAdmin: localStorage.getItem('isAdmin') === 'true' ? true : false,
            username: "",
            password: "",
		};
	},
    methods: {
        toggleAdmin() {
            this.isAdmin = !this.isAdmin;
            localStorage.setItem('isAdmin', this.isAdmin);
            // refresh page
            window.location.reload();
        },
        checkLogin() {
            if(this.username == "admin" && this.password == "admin") {
                this.toggleAdmin();
                document.getElementsByClassName("loginModal")[0].classList.toggle("hideModal");
                document.getElementsByClassName("voileNoir")[0].classList.toggle("hideModal");
            }
            else {
                alert("Mauvais identifiants");
            }
        },
    },
    emits: ["response"],
	watch: {
		isAdmin: function (isAdmin) {
			this.$emit("response", isAdmin);
		}
	},
};

window.addEventListener("DOMContentLoaded", () => {

    document.getElementById("login").addEventListener("click", () => {
        document.getElementsByClassName("loginModal")[0].classList.toggle("hideModal");
        document.getElementsByClassName("voileNoir")[0].classList.toggle("hideModal");
    });

    document.getElementsByClassName("voileNoir")[0].addEventListener("click", () => {
        document.getElementsByClassName("loginModal")[0].classList.toggle("hideModal");
        document.getElementsByClassName("voileNoir")[0].classList.toggle("hideModal");
    });
    
});

</script>

<template>
    <p>
        <a href="">Hugo Richard</a> -
        <a href="">Yanis Le Pors</a> -
        <a href="">Léo Couedor</a>
    </p>
    <button v-show="!isAdmin" id="login">Connexion</button>
    <button v-show="isAdmin" @click="toggleAdmin">Déconnexion</button>

    <!-- modale de connexion -->
    <div class="voileNoir"></div>
    <div class="loginModal">
        <div id="modal-content">
            <h1>Connexion</h1>
            <form action="">
                <label for="username">Nom d'utilisateur</label>
                <input v-model="username" type="text" name="username" id="username">
                <label for="password">Mot de passe</label>
                <input v-model="password" type="password" name="password" id="password">
                <input id="connexionButton" type="submit" @click="checkLogin" value="Se connecter">
            </form>
        </div>
    </div>
</template>