export class Experiencia {
    id? : number;
    puesto : string;
    descripcion : string;
    img_institucion : string;
    anioInicio : number;
    anioFin : number;
    personaId? : number;

    constructor(puesto: string, descripcion: string, img_institucion : string, anioInicio : number, anioFin: number){
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.img_institucion = img_institucion;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }
}