import { Board } from "./board";


export interface Message {
    id?: number;
    text?: string;
    createDateTime: Date;
    board?: Board;
}