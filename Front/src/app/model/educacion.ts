export class Educacion {
    id? : number;
    titulo : string;
    descripcion : string;
    img_institucion : string;
    anioInicio : number;
    anioFin : number;
    personaId? : number;

    constructor(titulo: string, descripcion: string, img_institucion : string, anioInicio : number, anioFin: number){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img_institucion = img_institucion;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }
}
