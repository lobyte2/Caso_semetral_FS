import { useState, useEffect } from 'react';
import { AlertaCard } from '../components/AlertaCard';

// Container: Maneja la lógica, el estado y busca los datos en el backend.
export const AlertasContainer = () => {
  const [alertas, setAlertas] = useState([]);

  // Simulamos la llamada a tu API Gateway (Microservicio de Alertas)
  useEffect(() => {
    // Aquí irá: fetch('http://localhost:8080/api/alertas')
    const alertasSimuladas = [
      { id: 1, ubicacion: "Sector Centro", nivelGravedad: 3, fecha: "2026-04-21" },
      { id: 2, ubicacion: "Zona Industrial", nivelGravedad: 5, fecha: "2026-04-21" }
    ];
    setAlertas(alertasSimuladas);
  }, []);

  return (
    <div>
      <h2>Monitoreo de Alertas Activas</h2>
      {/* El Container le pasa los datos al Presenter */}
      {alertas.map(alerta => (
        <AlertaCard 
          key={alerta.id} 
          ubicacion={alerta.ubicacion} 
          nivelGravedad={alerta.nivelGravedad} 
          fecha={alerta.fecha} 
        />
      ))}
    </div>
  );
};