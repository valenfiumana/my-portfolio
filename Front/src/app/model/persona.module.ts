export class persona {
    id?: number;
    nombre: String;
    apellido: String;
    apodo: String;
    url_img: String;
    sobreMi: String;
    github: String;
    linkedin: String;
    puesto: String;


    constructor(nombre: String, apellido:String, url_img: String, apodo: String, sobreMi: String, puesto: String, github: String, linkedin: String) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.url_img = url_img;
        this.apodo = apodo;
        this.sobreMi = sobreMi;
        this.puesto = puesto;
        this.github = github;
        this.linkedin = linkedin;
    }
}