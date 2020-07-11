export interface FileUpload {
  id: string;
  contentType: string;
  eventType: string;
  originalFilename: string;
  name: string;
  size: number;
  creationDate: Date;
  lastModifiedDate: Date;
}
