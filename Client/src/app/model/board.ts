import { Message } from "./message";


export interface Board {
    id?: number;
    title: string;
    messages?: Message[];
    createDateTime?: Date;
}

