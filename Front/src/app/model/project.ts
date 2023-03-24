export class Project {
    id? : number;
    titulo : string;
    url_imagen : string;
    url_proyecto : string;
    descripcion : string;
    personaId? : number;

    constructor(titulo: string, url_imagen: string, url_proyecto : string, descripcion : string){
        this.titulo = titulo;
        this.url_imagen = url_imagen;
        this.url_proyecto = url_proyecto;
        this.descripcion = descripcion;
    }
}
