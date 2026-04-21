// Presenter: Solo recibe datos (props) y los muestra en pantalla. No sabe de dónde vienen.
export const AlertaCard = ({ ubicacion, nivelGravedad, fecha }) => {
  return (
    <div style={{ border: '1px solid red', padding: '10px', margin: '10px 0' }}>
      <h3>Alerta de Emergencia</h3>
      <p><strong>Ubicación:</strong> {ubicacion}</p>
      <p><strong>Gravedad:</strong> Nivel {nivelGravedad}</p>
      <p><strong>Fecha:</strong> {fecha}</p>
    </div>
  );
};